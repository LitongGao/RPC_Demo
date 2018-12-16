package com.litong.rpc.client.info;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Data
@Service
public class RpcInfo {

    private String packageName;
    private String clazzName;
    private String methodName;
    private Object[] params;


}
