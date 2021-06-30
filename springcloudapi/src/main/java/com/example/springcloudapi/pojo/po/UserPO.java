package com.example.springcloudapi.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户类
 * @author xqr
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPO {

  private long uid;
  private String uname;
  private String pwd;
  private long version;



}
