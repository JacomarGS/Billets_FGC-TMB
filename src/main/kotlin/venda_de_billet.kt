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
            }
                print("|-------------------------------|\n"+
                        "|      ${ticketName}    |\n"+
                        "|-------------------------------|\n")

        }else if(option==2) {
            when (ticket) {
                1 -> ticketName = "T-dia        "
                2 -> ticketName = "T-4           "
            }

            print(
                "|-------------------------------|\n" +
                        "|      ${ticketName}    |\n" +
                        "|-------------------------------|\n"
            )
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

fun buyingTickets(): Int {
    var quantity = 1
    var finalOption: Boolean = false
    do {
        val userOption = readInt(
            pMessageIn = "Seleccioneu quantitat\n" + "1. Incrementar\n" + "2. Decrementar\n" + "0. Sortir"
            , pMessageErrorDT = "Opció incorrecta. Si us plau, seleccioneu 1 per incrementar o 2 per decrementar."
            , pMessageErrorDV = "Opció incorrecta. Si us plau, seleccioneu 1 per incrementar o 2 per decrementar."
            , pMin = 0
            , pMax = 2
        )
        when (userOption){
            1 -> quantity ++
            2 -> quantity--
            0 -> finalOption = true
        }
    } while (!finalOption)
    return quantity
}