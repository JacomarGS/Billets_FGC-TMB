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
    var confirmationWhitUser:String=" "
    var totalPurchase:Float=0f
    do {
        var counterTickets:Int=0
        var availableTransaction:Int=3
        var matrixForTicket:Array<Array<String>> = Array(3){Array(3){"."}}

        do{
            asciiArt()
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
                confirmationWhitUser = readWord(
                    pMessageIn = "Vols seguir compran? ($availableTransaction/3 " +
                            "transaccions disponibles) [S/N]",
                    pMessageErrorDT = "Introdueix un caracter valid"
                )
                    for (column in 0..matrixForTicket[0].size-1) {
                        if (column == 0) {
                            matrixForTicket[counterTickets][column] =userOption.toString()
                        } else if (column == 1) {
                            if (ticketPriceWhitoutZones == ticketFinalPrice) {
                                matrixForTicket[counterTickets][column] = " 1 zona"
                            } else if (ticketPriceWhitoutZones == ticketFinalPrice / 1.3125f) {
                                matrixForTicket[counterTickets][column] = " 2 zones"
                            } else {
                                matrixForTicket[counterTickets][column] = " 3 zones"
                            }
                        } else {
                            matrixForTicket[counterTickets][column] = " Preu del tiket:"+ ticketFinalPrice.toString()
                        }
                    }
                }
                counterTickets++

        }while ( availableTransaction!=0 && confirmationWhitUser.lowercase()=="s")
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
                                showTickets(ticket = matrixForTicket[line][column].toInt(),
                                    printTicket = false)
                            } else if (column == 1) {
                                print("${matrixForTicket[line][column]} ")
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
