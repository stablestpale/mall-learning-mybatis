package mall_mybatis.demo.service;

public interface RedisService {
    
    /*
     * @description: 存储数据
     * @param: [key, value]
     * @return: void
     * @date: 22:07 2021/7/12
     */
    void set(String key, String value);

    /*
     * @description: 获取数据
     * @param: [key]
     * @return: String
     * @date: 22:07 2021/7/12
     */
    String get(String key);

    /*
     * @description: 设置超期时间
     * @param: [key, expire]
     * @return: boolean
     * @date: 22:07 2021/7/12
     */
    boolean expire(String key, long expire);

    /*
     * @description: 删除数据
     * @param: [key]
     * @return: void
     * @date: 22:06 2021/7/12
     */
    void remove(String key);

    /*
     * @description: 自增操作
     * @param: [key, delta 自增步长]
     * @return: Long
     * @date: 22:06 2021/7/12
     */
    Long increment(String key, long delta);

}
