package com.design_parttern.behavioral;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MementoTest {
    public static void main(String[] args) {
        Original original = new Original("origin");
        Memento memento = original.getMemento();
        Storage storage = new Storage(memento);
        //原始
        System.out.println(original.getOrigin());

        original.setOrigin("after");

        System.out.println(original.getOrigin());
        // 备忘回滚
        original.setMemento(storage.getMemento());

        System.out.println(original.getOrigin());

    }
}

@Data
@AllArgsConstructor
class Memento {
    private String memento;
}

@Data
@AllArgsConstructor
class Original {
    private String origin;

    public Memento getMemento() {
        return new Memento(origin);
    }

    public void setMemento(Memento memento) {
        this.origin = memento.getMemento();
    }
}

@Data
@AllArgsConstructor
class Storage {
    private Memento memento;
}