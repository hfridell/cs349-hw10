package edu.umkc;

import java.lang.reflect.Field;
import acme.NetworkService;

public class Main {
  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
    NetworkService ns = new NetworkService();
    Class netClass = ns.getClass();

    Field machineName = netClass.getDeclaredField("machineName");
    machineName.setAccessible(true);
    machineName.set(ns, "aws.com");

     ns.connect();
  }
}
/*
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)

package acme;

public class NetworkService {
  private String machineName = "acme.com";

  public NetworkService() {
  }

  public void connect() {
    if("aws.com".equals(this.machineName)) {
      System.out.println("Success! Connected to " + this.machineName);
    } else {
      System.out.println("Error. Can not connect to " + this.machineName);
    }
  }
}
*/