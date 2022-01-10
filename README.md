# Adventures

API для разработки на [adventures - minecraft сервер](https://www.adventures-server.ru)

## Конфигурация settings.yml

### Информация о статусе api
| Данные | Описание |
|:------|:---------|
| **Server:** gateway | Название сервера на котором работает api |
| **Mode:** development | Режим в котором работает api ("poduction" - работа в основном потоке, "development" - работа в режиме разработчика (в этом режиме api будет проводить проверку ваших действий в общем потоке), "test" - тестирование работы c api) |
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
