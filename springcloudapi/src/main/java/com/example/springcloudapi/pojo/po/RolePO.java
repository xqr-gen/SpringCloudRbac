package com.example.springcloudapi.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色类
 * @author xqr
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePO {

  private long rid;
  private String rname;
  private long version;


}
