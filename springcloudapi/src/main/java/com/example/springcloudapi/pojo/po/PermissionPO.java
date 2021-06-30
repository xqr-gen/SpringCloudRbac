package com.example.springcloudapi.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  权限内容类
 * @author xqr
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionPO {

  private long pid;
  private String pname;
  private long version;



}
