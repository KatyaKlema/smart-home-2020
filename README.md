# Задание 
Прочитать про шаблоны
- Декоратор
https://refactoring.guru/ru/design-patterns/decorator
- Шаблонный метод
https://refactoring.guru/ru/design-patterns/template-method
- Состояние
https://refactoring.guru/ru/design-patterns/state


- Реализовать новый объект - сигнализацию. Сигнализация должна поддерживать три состояния: деактивирована, активирована (дом на охране), тревога (звучит сирена, моргает свет в доме и т.п.).
С сигнализацией можно делать следующее:
активировать (используя код), деактивировать (используя код, если код не совпадает с кодом активации сигнализация переходит в режим тревоги), перевести в режим тревоги.
Для реализации Сигнализации необходимо использовать шаблон “состояние”. Покрыть unit-тестами.
- Необходимо добавить два новых типа события: ALARM_ACTIVATE (с полем code), ALARM_DEACTIVATE (с полем code), а также обработчики этих событий, которые будут вызывать соответствующие методы сигнализации.
- Декоратор: если сигнализация находится в состоянии “активирована”, то любое событие от сенсоров (включение/выключение света, открытие/закрытие двери) должно:
переводить сигнализацию в режим тревоги
отправлять смс уведомление (сделайте просто System.out(“Sending sms”);)
- Если сигнализация находится в режиме тревоги, то остальные обработчики событий должны игнорировать любые события, смс должны продолжать отправляться.


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
