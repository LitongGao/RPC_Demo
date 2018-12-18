package com.litong.rpc.info;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Data
@Service
public class RpcInfo implements Serializable {

    private static final long serialVersionUID = -2045233641086354038L;
    private String packageName;
    private String clazzName;
    private String methodName;
    private Object[] params;


}
