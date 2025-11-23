package springproxies;

import java.lang.reflect.Proxy;

import springproxies.classes.Man;
import springproxies.classes.Person;
import springproxies.classes.PersonInvocationHandler;

public class App {

    public static void main(String[] args) {
        Man leela = new Man("Leela Sai", 26, "Vizag", "India");
        ClassLoader leelaClassLoader = leela.getClass().getClassLoader();
        Class[] interfaces = leela.getClass().getInterfaces();
        Person proxyleela = (Person) Proxy.newProxyInstance(leelaClassLoader, interfaces,
                new PersonInvocationHandler(leela));
        proxyleela.introduce(leela.getName());
    }
}
