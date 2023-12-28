package org.example

import java.util.Scanner
val scanner = Scanner(System.`in`)

/**
 * showTickets
 */
fun showTickets(option:Int=1){
    val ticketsOption1:Int=6
    val ticketsOption2:Int=2
    var ticketName:String=""
    if(option==1){
        for(ticket in 1..ticketsOption1){
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
        }
    }else if(option==2){
        for(ticket in 1..ticketsOption2){
            when(ticket){
                1-> ticketName="T-dia        "
                2->ticketName="T-4           "
            }
            print("|-------------------------------|\n"+
                    "|      ${ticketName}    |\n"+
                    "|-------------------------------|\n")
        }
    }
}

fun choosingAnOptionInMenu1(): Int {
    val userOptionInMenu1 = readInt(
        pMessageIn = "Seleccioneu tipus de billet"
        , pMessageErrorDT = "Opció incorrecta. Si us plau, seleccioneu una de les opcions mostrades per pantalla."
        , pMessageErrorDV = "Opció incorrecta. Si us plau, seleccioneu una de les opcions mostrades per pantalla."
        , pMin = 1
        , pMax = 6
    )
    return userOptionInMenu1
}

fun choosingAnOptionInMenu2(): Int {
    val userOptionInMenu2 = readInt(
        pMessageIn = "Seleccioneu tipus de billet"
        , pMessageErrorDT = "Opció incorrecta. Si us plau, seleccioneu una de les opcions mostrades per pantalla."
        , pMessageErrorDV = "Opció incorrecta. Si us plau, seleccioneu una de les opcions mostrades per pantalla."
        , pMin = 1
        , pMax = 2
    )
    return userOptionInMenu2
}