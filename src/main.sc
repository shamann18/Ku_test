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
        a: Куууу?
        image: data:image/jpeg;base64,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
        go!: /Start

    state: KeTse
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