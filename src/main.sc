require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start || sessionResult = "Сценарий начинается отсюда", sessionResultColor = "#143AD1"
        q!: $regex</start>
        a: Добрый день! Я - последний выдох господина ПЖ. || htmlEnabled = true, html = "Добрый день! Я - последний выдох господина ПЖ."
        image: https://dic.academic.ru/pictures/wiki/files/75/Kin-dza-dza-photo-5.jpg
        buttons:
            "Хочу малиновые штаны" -> /КЦ
        event: noMatch || toState = "/Nomatch"

    state: Bye
        a: Скрипач не нужен.
        image: https://i.ytimg.com/vi/h6cftEjw5zU/maxresdefault.jpg
        EndSession: 
            actions = {}
        a: Чат завершен.
        buttons:
            "Я передумал, давай еще раз. " -> /Start

    state: Nomatch
        event!: noMatch
        a: Ку?

    state: КЦ
        a: Должно быть много КЦ. У тебя много КЦ?
        intent: /Да || toState = "/Получи штаны"
        intent: /Нет || toState = "/Эцилопп"
        event: noMatch || toState = "/Nomatch"

    state: Получи штаны
        a: Тогда держи
        image: https://club.season.ru/uploads/post/1988/538/post-1988-1504023538.jpg
        go!: /Success

    state: Эцилопп
        a: Тогда пройдемте сюда.
        image: https://dic.academic.ru/pictures/wiki/files/80/Pepelac_ecilop.jpg
        go!: /Tranclucated

    state: Tranclucated
        image: https://data.cyclowiki.org/images/4/48/%D0%A2%D1%80%D0%B0%D0%BD%D0%BA%D0%BB%D1%8E%D0%BA%D0%B0%D1%82%D0%BE%D1%80_%D1%83_%D0%B4%D1%8F%D0%B4%D0%B8_%D0%92%D0%BE%D0%B2%D1%8B.JPG
        a: Вы транклюкированы.
        go!: /TryAgain
        event: noMatch || toState = "./"

    state: Success
        a: Хотите голубые штаны?
        intent: /Да || toState = "/LastBreathPZIsInDanger"
        intent: /Нет || toState = "/GoodLad"
        event: noMatch || toState = "/Nomatch"

    state: LastBreathPZIsInDanger
        a: Кю! Вы посягнули на последний выдох господина ПЖ.
        go!: /Tranclucated

    state: GoodLad
        a: Когда у общества нет цветовой дифференциации штанов, то нет цели! А когда нет цели...
        go!: /Success

    state: TryAgain
        a: Еще раз?
        buttons:
            "Дядя, жми на время. " -> /Start
            "Фигушки." -> /Bye
