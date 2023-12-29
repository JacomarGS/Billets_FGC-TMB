package org.example

fun asciiArt(){
    println("\n" +
            "\n" +
            "                                                                                                                                                                                                        \n" +
            "                                                                                                                                                                                                        \n" +
            "                                                                                                                                                                                                        \n" +
            RED + "                              .:===-.                   "+ RESET + GREEN +"                                                                                                                                                \n" + RESET +
            RED + "                     =######################.           "+ RESET + GREEN +"                                                  ======================================                                                        \n" + RESET +
            RED + "                =###############################        "+ RESET + GREEN +"                                                  ======================================                                                        \n" + RESET +
            RED + "            .#####################################.     "+ RESET + GREEN +"                                                  ======================================                                                        \n" + RESET +
            RED + "          ##########################################    "+ RESET + GREEN +"                                                  ======================================                                                        \n" + RESET +
            RED + "        ######= #####################################   "+ RESET + GREEN +"                                                  ======================================                                                        \n" + RESET +
            RED + "      #####. +########################################  "+ RESET + GREEN +"                                                  ======================================                                                        \n" + RESET +
            RED + "    +###=  ###########################################: "+ RESET + GREEN +"                                                  ======================================                                                        \n" + RESET +
            RED + "   ###-  *############################################# "+ RESET + GREEN +"                                                  ======================================                                                        \n" + RESET +
            RED + "  ###   #####         #     ###     ##         ######## "+ RESET + GREEN +"                                                  ==================-    .====-              @@@@@@@@@@@@@     @@@@@@@@@@@        @@@@@@@@@@@   \n" + RESET +
            RED + " ##=  .#####+++   -++#.  .  ##  .  .#:   ###   #######: "+ RESET + GREEN +"                                                  ================-    .====:                @@@@@@@@@@@@@   @@@@@@@@@@@@@@@    @@@@@@@@@@@@@@@ \n" + RESET +
            RED + ".#-  .########+   ####   =  #  +   ##         ########  "+ RESET + GREEN +"                                                  ==============:    .====:    .========     @@@@@          @@@@@       @@@@   @@@@@       @@@@@\n" + RESET +
            RED + "#*   #########   ####.  =-    *.  :#.  .**:   #######.  "+ RESET + GREEN +"                                                  =============    .====:    :====.   ==     @@@@@          @@@@               @@@@@            \n" + RESET +
            RED + "#   .########=   ####   #-   ##   ##   ###.   ######.   "+ RESET + GREEN +"                                                  =============   .===.    :====    .===     @@@@@@@@@@@@   @@@@     @@@@@@@@  @@@@             \n" + RESET +
            RED + "*   =########   ####   +#-  ##.  =#         #######     "+ RESET + GREEN +"                                                  =============   .=-    -====     ====-     @@@@@@@@@@@@   @@@@     @@@@@@@@  @@@@             \n" + RESET +
            RED + ".   :#############################################      "+ RESET + GREEN +"                                                  =============   .==..-===-    .====-       @@@@@          @@@@@       @@@@@  @@@@@       @@@@@\n" + RESET +
            RED + "     ###########################################        "+ RESET + GREEN +"                                                  =============   .======-    .====-         @@@@@           @@@@@     @@@@@@   @@@@@     @@@@@ \n" + RESET +
            RED + "     #########################################          "+ RESET + GREEN +"                                                  =============             .====-    .=     @@@@@            @@@@@@@@@@@@@@@    @@@@@@@@@@@@@  \n" + RESET +
            RED + "      #####################################+            "+ RESET + GREEN +"                                                  =============::::::::::::=====:::::===     @@@@@               @@@@@@@  @@@       @@@@@@@@    \n" + RESET +
            RED + "       .#################################               "+ RESET + GREEN +"                                                  ======================================                                                        \n" + RESET +
            RED + "         .###########################-                  "+ RESET + GREEN +"                                                  ======================================                                                        \n" + RESET +
            RED + "             ####################                       "+ RESET + GREEN +"                                                  ======================================                                                        \n" + RESET +
            RED + "                     ....                               "+ RESET + GREEN +"                                                                                                                                              \n" + RESET +
            "                                                                                                                                                                                                        \n" +
            "                                                                                                                                                                                                        \n" +
            "                                                                                                                                                                                                        \n" +
            "\n")
}

fun main() {
    var secretCode:Int=0
    val TOTAL_TICKETS:Int=12
    var availableTransaction:Int=3
    var confirmationWhitUser:String=" "
    var totalPurchase:Float=0f
    var matrixForTicket:Array<Array<String>> = Array(3){Array(3){"."}}
    var counterTickets:Int=0
    do {
        do{
            for (ticket in 1..TOTAL_TICKETS) {
                println("$ticket:")
                showTickets(option = 1, ticket = ticket)
                println()
            }
            val userOption = readInt(
                pMessageIn = "Seleccioneu tipus de billet (introduiu el numero)",
                pMessageErrorDT = "Opció incorrecta. Si us plau, seleccioneu una de les opcions mostrades per pantalla.",
                pMessageErrorDV = "Opció incorrecta. Si us plau, seleccioneu una de les opcions mostrades per pantalla.",
                pMin = 1,
                pMax = TOTAL_TICKETS
            )
            var ticketPriceWhitoutZones: Float = quantityTickets(ticket = userOption)
            if (ticketPriceWhitoutZones != 0f) {
                var quantityTickets:Int=unknownTicktetQuantity(ticketPriceWhitoutZones=ticketPriceWhitoutZones,
                    ticketType=userOption)
                var ticketFinalPrice: Float = travelZones(price = showTickets(option = 2, ticket = userOption),
                    quantity =quantityTickets )
                println("El total de la compra actual son $ticketFinalPrice€")
                totalPurchase += ticketFinalPrice
                availableTransaction--
                counterTickets++
                confirmationWhitUser = readWord(
                    pMessageIn = "Vols seguir compran? ($availableTransaction/3 " +
                            "transaccions disponibles) [S/N]",
                    pMessageErrorDT = "Introdueix un caracter valid"
                )
                for (line in 0..counterTickets-1) {
                    for (column in 0..counterTickets-1) {
                        if (column == 0) {
                            matrixForTicket[line][column] = userOption.toString()
                        } else if (column == 1) {
                            if (ticketPriceWhitoutZones == ticketFinalPrice) {
                                matrixForTicket[line][column] = "1"
                            } else if (ticketPriceWhitoutZones == ticketFinalPrice / 1.3125f) {
                                matrixForTicket[line][column] = "2"
                            } else {
                                matrixForTicket[line][column] = "3"
                            }
                        } else {
                            matrixForTicket[line][column] = ticketFinalPrice.toString()
                        }
                    }
                }
            }
        }while (confirmationWhitUser.lowercase() == "s" || availableTransaction<=0)
        if (totalPurchase!=0f) {
            buyingTicket(totalPurchase)
            confirmationWhitUser = readWord(
                pMessageIn = "Vols el tiquet de la compra? [S/N]",
                pMessageErrorDT = "Introdueix un caracter valid"
            )
            if (confirmationWhitUser.lowercase()=="s") {
                for (line in 0..matrixForTicket.size - 1) {
                    for (column in 0..matrixForTicket[line].size - 1) {
                        if (matrixForTicket[line][column] != ".") {
                            if (column   == 0) {
                                showTickets(ticket = matrixForTicket[line][column].toInt(), printTicket = false)
                            } else if (column == 1) {
                                print("${matrixForTicket[column][line]} ")
                            } else {
                                print("${matrixForTicket[line][column]} ")
                            }


                        }
                    }
                    println()
                }
            }
        }


    }while (secretCode!=-1)
}
