package mall_mybatis.demo.utils;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jdk.nashorn.internal.parser.TokenKind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zzy
 * @description:
 * @date 2021/7/13 10:34
 */


@Component
public class JwtTokenUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    /*
     * @description: 生成token
     * @param: [claims]
     * @return: String
     * @date: 10:46 2021/7/13
     */
    private String generateToken(Map<String, Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .compact();
    }

    /*
     * @description: 根据用户信息生成token
     * @param: [userDetails]
     * @return: String
     * @date: 11:03 2021/7/13
     */
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /*
     * @description: 刷新token
     * @param: [token]
     * @return: String
     * @date: 11:05 2021/7/13
     */
    public String freshToken(String token){
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /*
     * @description: 生成过期时间
     * @param: []
     * @return: Date
     * @date: 10:47 2021/7/13
     */
    private Date generateExpirationDate(){
        return new Date(System.currentTimeMillis() + expiration.longValue() * 1000);
    }

    /*
     * @description: 获取token中的claim
     * @param: [token]
     * @return: Claims
     * @date: 10:56 2021/7/13
     */
    private Claims getClaimsFromToken(String token){
        Claims claims = null;
        try{
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e){
            LOGGER.info("JWT验证失败:{}", token);
        }
        return claims;
    }

    /*
     * @description: 验证token是否失效
     * @param: [token, userDetails]
     * @return: Boolean
     * @date: 10:57 2021/7/13
     */
    public Boolean validateToken(String token, UserDetails userDetails){
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !validateExpiration(token);
    }

    /*
     * @description: 验证token是否过期
     * @param: [token]
     * @return: Boolean
     * @date: 11:01 2021/7/13
     */
    private Boolean validateExpiration(String token){
        Date expireDate = getExpirationDateFromToken(token);
        return expireDate.before(new Date());
    }

    /*
     * @description: 获取用户名
     * @param: [token]
     * @return: String
     * @date: 10:56 2021/7/13
     */
    public String getUserNameFromToken(String token){
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e){
            username = null;
        }
        return username;
    }

    /*
     * @description: 获取过期时间
     * @param: [token]
     * @return: Date
     * @date: 11:00 2021/7/13
     */
    private Date getExpirationDateFromToken(String token){
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }


}
