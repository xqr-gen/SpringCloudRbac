package com.example.springcloudapi.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色权限类
 * @author xqr
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RpPO {

  private long id;
  private long rid;
  private long pid;
  private long version;


}
