import org.jsoup.Jsoup
import java.sql.DriverManager

fun main() {
//следующая строка для пролучения страницы для парсинга 4х20
    val result4x20 = Jsoup.connect("https://www.stoloto.ru/4x20/archive").get()
// две следующие строки для получения ТЕСТОВОГО ТЕКСТА ДЛЯ ПАРСИНГА ИЗ ФАЙЛА D:\\Users\\Documents\\stoloSRC.txt  ИХ РАСКОМЕНТИРОВАТЬ ДЛЯ ТЕСТОВ,А ПРЕДЫДУЩУЮ ЗАКОМЕНТИРОВАТЬ
//val f = File("D:\\Users\\Documents\\stoloSRC.txt")
//val result4x20 = Jsoup.parse(f)
// Получаем все блокие "elem"
    val elem = result4x20.select("div.elem")
    val connection = DriverManager.getConnection("jdbc:sqlite:stoloto.db")
    val statement = connection.prepareStatement("SELECT * FROM lottery")
    val resSet = statement.executeQuery()

    while (resSet.next()){
        print(resSet.getInt(1))
        print("  ")
        println(resSet.getInt(2))

    }
    //проходим по всем блокам "элем"
    /*for (e in elem) {
        val date = e.select("div.draw_date").text() // находим дату
        val tiraj = e.select("div.draw").text() // находим номер тиража
        val nums = e.select("span.zone") // находим span с классом zone,
        //проходим по всем span.zone
        for (n in nums) {
            val num = n.select("b")
            for (n1 in num) {
                print("${n1.text()} ")
            }
        }
        println("Тираж : $tiraj от $date числа")
    }*/
}