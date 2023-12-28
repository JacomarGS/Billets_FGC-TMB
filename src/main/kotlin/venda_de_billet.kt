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
fun showTickets(option:Int=1, ticket:Int=1):Float{
    val ticketsOption1:Int=6
    val ticketsOption2:Int=2
    var ticketName:String=""
        if(option==1){
            when(ticket){
                1-> ticketName="Billet aeroport        "
                2->ticketName="Billet sencill          "
                3->ticketName="Hola Barcelona 2 Dies"
                4->ticketName="Hola Barcelona 3 Dies"
                5->ticketName="Hola Barcelona 4 Dies"
                6->ticketName="Hola Barcelona 5 Dies"
                7->ticketName = "T-dia        "
                8 -> ticketName = "T-4           "
            }
                print("|-------------------------------|\n"+
                        "|      ${ticketName}    |\n"+
                        "|-------------------------------|\n")

        }
        when(ticket){
            1-> if (option==1) return 5.15f else if (option==2) return 10.50f
            2-> if (option==1) return 2.40f else if (option==2) return 2f
            3-> if (option==1) return 16.40f
            4-> if (option==1) return 23.80f
            5-> if (option==1) return 31f
            6-> if (option==1) return 38.20f
        }

    return 0f
}

/**
 * reading the option chosen by the user
 */
val userOptionInMenu1 = readInt(
    pMessageIn = "Seleccioneu tipus de billet"
    , pMessageErrorDT = "Opció incorrecta. Si us plau, seleccioneu una de les opcions mostrades per pantalla."
    , pMessageErrorDV = "Opció incorrecta. Si us plau, seleccioneu una de les opcions mostrades per pantalla."
    , pMin = 1
    , pMax = 6
)

val userOptionInMenu2 = readInt(
    pMessageIn = "Seleccioneu tipus de billet"
    , pMessageErrorDT = "Opció incorrecta. Si us plau, seleccioneu una de les opcions mostrades per pantalla."
    , pMessageErrorDV = "Opció incorrecta. Si us plau, seleccioneu una de les opcions mostrades per pantalla."
    , pMin = 1
    , pMax = 2
)
fun quantityTickets():Int{
    var quantity = 1
    var finalOption: Boolean = false
    do {
        if (quantity>1){
            println("$quantity - Billet")
        }else{
            println("$quantity - Billets")
        }
        println(showTickets()*quantity)
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
            0 -> quantity = 0
        }
    } while (!finalOption || quantity==0)
    return quantity
}

fun travelZones(quantity:Float): Float{
    var priceOfTheTicket = quantity
        val userOption = readInt(
            pMessageIn = "Seleccioneu la zona:\n" + "1. Zona 1\n" + "2. Zona 2\n" + "3. Zona 3\n" + "0. Anul·lar"
            , pMessageErrorDT = "Opció incorrecta. Si us plau, seleccioneu una de les opcions mostrades per pantalla."
            , pMessageErrorDV = "Opció incorrecta. Si us plau, seleccioneu una de les opcions mostrades per pantalla."
            , pMin = 1
            , pMax = 3
        )
        when (userOption){
            1 -> priceOfTheTicket * 1f
            2 -> priceOfTheTicket * 1.3125f
            3 -> priceOfTheTicket * 1.8443f
        }
    return priceOfTheTicket
}

