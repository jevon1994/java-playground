package com.design_parttern.creation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * \建造者模式
 */
@Slf4j
public class BuilderTest {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Engineer engineer = new Engineer(builder);
        Rocket rocket = engineer.create();
        log.info("{}", rocket);
    }
}

interface Builder {
    void buildEngine();

    void buildConsole();

    Rocket buildRocket();
}

@Data
class Rocket {
    private String engine;
    private String console;

    void launch() {
        System.out.println("rocket launch");
    }
}

class ConcreteBuilder implements Builder {
    private Rocket rocket = new Rocket();

    @Override
    public void buildEngine() {
        rocket.setEngine("engine");
    }

    @Override
    public void buildConsole() {
        rocket.setConsole("console");
    }

    @Override
    public Rocket buildRocket() {
        return rocket;
    }
}

@AllArgsConstructor
class Engineer {
    private Builder builder;

    public Rocket create() {
        builder.buildConsole();
        builder.buildEngine();
        return builder.buildRocket();
    }
}
