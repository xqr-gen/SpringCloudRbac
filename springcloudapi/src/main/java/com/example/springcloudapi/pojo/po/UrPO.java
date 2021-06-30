package com.example.springcloudapi.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户角色类
 * @author xqr
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrPO {

  private long uid;
  private long rid;
  private long version;


}
