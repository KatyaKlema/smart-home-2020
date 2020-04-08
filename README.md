# Задание
Прочитать про шаблоны
- Адаптер
https://refactoring.guru/ru/design-patterns/adapter
- Singleton
https://refactoring.guru/ru/design-patterns/singleton

- Пришло оборудование для умного дома и к нему шла библиотека, которая предоставляет API для работы с сенсорами. Это API можно взять в проекте smart-home-2019, в ветке library:
https://github.com/sbt-agoshkov/smart-home-2020/tree/library
(в репозитории API лежит в виде исходного кода, на самом деле нужно представить, что исходного кода нет, есть готовый jar файл с API, изменять который мы естественно не можем и не должны).
Единственный исходный код, который был вместе с API - это пример использования (класс ```Sample```).
- Вам необходимо подключить это API к нашему проекту умного дома, при этом хотелось бы переписать минимальное количество кода.
Для подключения библиотеки необходимо использовать шаблон адаптер.
- Также необходимо перевести проект на spring IoC: 
http://spring-projects.ru/guides/lessons/lesson-1/
http://spring-projects.ru/guides/lessons/lesson-2
После подключения Spring ваш “главный класс” должен стать примерно таким:

```java
public class Application {

   public static void main(String[] args) {
       AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
       SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
       sensorEventsManager.start();
   }
  
}
```



# Smart Home

The project implements a "smart home". The house has sensors which are connected to the central server. Sensors send 
events when lights are turned on/off or doors are opened/closed.

## Classes description

- The system receives events of type SensorEvent
- SmartHome – the home itself, it contains rooms
- Room – a room, it contains doors and lights
- Door – a door (interior or entrance one)
- Light – a source of light (e.g. light bulb)
- SensorEvent – physical world event
- SensorEventType – event type (4 types)
- SensorCommand – a command which allows programmatically manage the physical world
(turn lights on/off, open/close door)
- CommandType – command type (1 type - turn lights off)

## Coding hints

Stick to generally accepted Java style guidelines (e.g. [Oracle](https://www.oracle.com/technetwork/java/codeconventions-135099.html)
or [Google](https://google.github.io/styleguide/javaguide.html)) when you name methods, classes or variables. Apply 
__same__ guidelines __everywhere__ in the project.

Inheritance between classes is not particularly useful in this project. Try not to use it each time you think you need 
one.

Follow [Tell-Don't-Ask](https://martinfowler.com/bliki/TellDontAsk.html) principle during class interactions design.

There may be many potential reasons to change for a project. Keep in mind that the most probable ones for this project are:

- New house objects
- New event types
- Increasing complexity of events

Separate __configuration__ code (e.g. dependencies setup, changes frequently) from __business logic__ code (e.g. opening 
door event handling routine, changes not so frequently).

Watch out for introducing [leaky abstractions](https://en.wikipedia.org/wiki/Leaky_abstraction) into your code (e.g. 
an abstraction for reading data must not know if the implementation does it with file IO or through network).
