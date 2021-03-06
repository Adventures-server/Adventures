# Adventures

API для разработки на [Adventures - minecraft сервер](https://www.adventures-server.ru)

## Добавление API в maven зависимость
### Репозиторий для pom.xml
```xml
<repository>
    <id>Adventures-mvn-repo</id>
    <url>https://raw.github.com/adventures-server/Adventures/mvn-repo/</url>
    <snapshots>
    <enabled>true</enabled>
    <updatePolicy>always</updatePolicy>
    </snapshots>
</repository>
```
### Зависимость для pom.xml
```xml
<dependency>
    <groupId>ru.adventures</groupId>
    <artifactId>adventures</artifactId>
    <version>1.0</version>
    <scope>provided</scope>
</dependency>
```

## Создание запросов в базу данных

### UPDATE запросы в базу данных:
```java
Adventures.connection.update("CREATE TABLE IF NOT EXISTS `table-name` (`id` int(11) NOT NULL auto_increment, PRIMARY KEY  (`id`))");
```

### SELECT запросы в базу данных:
Получить содержимое колонн из указанной таблици. Пример condition: player='steve'
```java
Adventures.connection.select("SELECT column, column FROM table WHERE condition"); //возвращает ResultSet
```
#### Работа с результатом запроса SELECT (ResultSet):
```java
String name; //Назначение переменной "имя"
int age; //Назначение переменной "возраст"
ResultSet result = Adventures.connection.select("SELECT name, age FROM player_data WHERE player='steve'"); //Создание запроса
try {
    while (result.next()) {
    name = result.getString("name"); //Запись данных с таблицы в переменную
    age = result.getInt("age"); //Запись данных с таблицы в переменную
    }
} catch (SQLException throwables) {
    Logger.error(throwables.getMessage()); //Вывод сообщения об ошибке при неправильном запросе
}
```
## Работа с сериалайзерами компонентов
#### Для удобства работы с текстовыи компонентами были сделаны сокращенные методы
#### Из Component в Legacy String:
```java
String something = Components.LegacyString(component); //TextComponent component = Component.text("Привет");
```
#### Из Component в Gson String:
```java
String something = Components.GsonString(component); //TextComponent component = Component.text("Привет");
```
#### Из Component в Plain String:
```java
String something = Components.GsonString(component); //TextComponent component = Component.text("Привет");
```
#### Из Legacy String в Component:
```java
TextComponent something = Components.LegacyComponent("Привет");
```
#### Из Gson String в Component:
```java
TextComponent something = Components.GsonComponent("Привет");
```
#### Из Plain String в Component:
```java
TextComponent something = Components.PlainComponent("Привет");
```

### UPDATE запросы в базу данных:


## Конфигурация settings.yml

### Информация о статусе api
| Данные | Описание |
|:------|:---------|
| **Server:** gateway | Название сервера на котором работает api |
| **Mode:** development | Режим в котором работает api ("poduction" - работа в основном потоке, "development" - работа в режиме разработчика (в этом режиме api будет проводить проверку ваших действий в общем потоке), "test" - режим тестирования работы c api) |
| **api-id:** 145 | Идентификатор рабочего api (Нужен для быстрого поиска в основном потоке) |

### Информация о соединении с базой данных mysql
| Данные | Описание |
|:------|:---------|
| address: localhost | IP адрес хоста |
| port: '3306' | Порт для соединения с базой данных (Ковычки не стирать) |
| database: database | Название базы данных |
| username: username | Имя пользователя базы данных |
| password: password | Пароль от пользователя базы данных |
| ssl: false | Использоваие протокола ssl при подключении |
| minimumIdle: 2 | Минимальное количество незанятых соединений в пуле соединений |
  maximumPoolSize: 10 | Максимальное количество незанятых соединений в пуле соединений |
  connectionTimeout: 1500 | Время ожидания соединения |

