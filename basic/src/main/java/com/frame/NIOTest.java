package com.frame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NIOTest {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("")){

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
