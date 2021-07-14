package mall_mybatis.demo.mbg.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mall_mybatis.demo.mbg.model.UmsAdmin;
import mall_mybatis.demo.mbg.model.UmsPermission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zzy
 * @description:
 * @date 2021/7/14 16:28
 */

@NoArgsConstructor
@AllArgsConstructor
public class AdminUserDetailsDTO implements UserDetails {
    private UmsAdmin umsAdmin;
    private List<UmsPermission> umsPermissions;

    /*
     * @description: 返回当前用户权限
     * @param: []
     * @return: Collection<GrantedAuthority>
     * @date: 16:32 2021/7/14
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return umsPermissions.stream()
                .filter(umsPermission -> umsPermission.getValue() != null)
                .map(umsPermission -> new SimpleGrantedAuthority(umsPermission.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(1);
    }
}
