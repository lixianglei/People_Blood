package com.example.admin.people_blood.bean;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/10 08:49
 * 修改人:
 * 修改内容:这是字母栏搜索的实体类
 * 修改时间:
 */

public class User {
    private String  Username;
    private String  FirstCharacter;

    public User(String username, String firstCharacter) {
        Username = username;
        FirstCharacter = firstCharacter;
    }

    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }

    public User(String username) {
        Username = username;
    }

    public String getFirstCharacter() {
        return FirstCharacter;
    }

    public void setFirstCharacter(String firstCharacter) {
        FirstCharacter = firstCharacter;
    }
}
