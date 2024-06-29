package com.spring3.common.config.runner;

import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lijiyun
 * @date 2024/06/10 19:42
 */
@Component
@Order(0)
public class SystemInitConfig implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        IdGeneratorOptions options = new IdGeneratorOptions((short) 0);
        YitIdHelper.setIdGenerator(options);
        System.out.println("============= 雪花id配置完成");
    }
}
