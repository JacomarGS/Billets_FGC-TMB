package org.example


import java.util.Scanner
val scanner = Scanner(System.`in`)


/**
 * showTickets
 * @author pol.paredes
 * @since Commit 6 (28/12/2023)
 * @param option , based on the number it treats a diferent menu (Int)
 * @param ticket , determines what ticket is the afected one (Int)
 * @return Output value (Float)
 */
fun showTickets(option:Int=1, ticket:Int=1, printTicket:Boolean=true):Float{
    var ticketName:String=""
    if(option==1){
        when(ticket){
            1-> ticketName="Billet aeroport"
            2->ticketName="Billet sencill"
            3->ticketName="Hola Barcelona 2 Dies"
            4->ticketName="Hola Barcelona 3 Dies"
            5->ticketName="Hola Barcelona 4 Dies"
            6->ticketName="Hola Barcelona 5 Dies"
            7->ticketName = "T-dia"
            8 -> ticketName = "T-4"
            9->ticketName="TCasual"
            10->ticketName="TUsual"
            11->ticketName="TFamiliar"
            12->ticketName="TJove"
        }
        if (printTicket) {
            print(
                "|-------------------------------|\n" +
                        "|      ${ticketName}    |\n" +
                        "|-------------------------------|\n"
            )
        }else{
            print(ticketName)
        }
    }
    when(ticket){
        1-> return 5.15f
        2-> return 2.40f
        3-> return 16.40f
        4-> return 23.80f
        5-> return 31f
        6-> return 38.20f
        7->  return 10.50f
        8-> return 2f
        9-> return 11.35f
        10-> return 40f
        11-> return 10f
        12-> return 80f
    }


    return 0f
}




fun quantityTickets(ticket: Int):Float{
    var quantity = 1
    var finalOption: Boolean = false
    var price:Float=showTickets(option = 1, ticket=ticket)*quantity
    do {
        if (quantity<=0) {
            quantity=1
            println("No es poden menys de zero billets $quantity - Billet")
        }else if (quantity<2){
            println("$quantity - Billet")
        }else if (quantity<=3){
            println("$quantity - Billets")
        }else{
            quantity=3
            println("No es poden més de tres billets $quantity - Billets")
        }
        println(price*quantity)
        val userOption = readInt(
            pMessageIn = "Seleccioneu quantitat\n" + "1. Incrementar\n" + "2. Decrementar\n" + "3. Confirmar\n" +
                    "0. Anul·lar"
            , pMessageErrorDT = "Opció incorrecta. Si us plau, seleccioneu una de les opcions mostrades per pantalla."
            , pMessageErrorDV = "Opció incorrecta. Si us plau, seleccioneu una de les opcions mostrades per pantalla."
            , pMin = 0
            , pMax = 3
        )
        when (userOption){
            1 -> quantity ++
            2 -> quantity--
            3 -> finalOption = true
            0 -> return 0f
        }
    } while (!finalOption)
    return price
}


/**
 * buyingTicket
 * @since Commit 11 (28/12/2023)
 * @param price, the price of the ticket (Float)
 */
fun buyingTicket(price:Float){
    var userMoney:Float=price
    do {
        userMoney -= readFloatCash(
            pMessageIn = "Has de pagar $userMoney\n" + "Siusplau introdueix monedes o billets d'euro valides",
            pMessageErrorDT = "Introdueix diners de veritat")
    }while (userMoney>=0)
    if (userMoney<=0){
        println("Reculli el seu bitllet i el canvi: ${userMoney*(-1)}")
    }
}


fun travelZones(price:Float, quantity:Int): Float{
    var priceOfTheTicket = price
    val userOption = readInt(
        pMessageIn = "Seleccioneu la zona:\n" + "1. Zona 1\n" + "2. Zona 2\n" + "3. Zona 3\n" + "0. Anul·lar",
        pMessageErrorDT = "Opció incorrecta. Si us plau, seleccioneu una de les opcions mostrades per pantalla.",
        pMessageErrorDV = "Opció incorrecta. Si us plau, seleccioneu una de les opcions mostrades per pantalla.",
        pMin = 1,
        pMax = 3
    )
    when (userOption) {
        1 -> priceOfTheTicket *= 1f
        2 -> priceOfTheTicket *= 1.3125f
        3 -> priceOfTheTicket *= 1.8443f
    }
    if (quantity==2){
        priceOfTheTicket=priceOfTheTicket*2
    }else if (quantity==3){
        priceOfTheTicket=priceOfTheTicket*3
    }
    return priceOfTheTicket
}


fun unknownTicktetQuantity(ticketPriceWhitoutZones:Float, ticketType:Int):Int {
    var ticketPrice: Float = showTickets(option = 2, ticket =ticketType)
    if (ticketPrice==ticketPriceWhitoutZones){
        return 1
    }else if (ticketPrice==ticketPriceWhitoutZones/2){
        return 2
    }else if (ticketPrice==ticketPriceWhitoutZones/3){
        return 3
    }
    return 0
}
