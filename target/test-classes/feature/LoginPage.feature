Feature: Verify AdactinHotel loginDetails

  Scenario Outline: Verify AdactinHotel login with valid data
    Given User is in Adactin Hotel login page
    When User should enter valid "<username>" and "<password>"
    And User should searchHotel "<location>","<hotels>","<roomType>","<numOfRooms>","<checkinDate>","<checkoutDate>","<adultRoom>" and "<childRoom>"
    And User should continue selectHotel
    And User should bookHotel "<firstName>","<lastName>","<address>","<ccNumber>","<ccType>","<ccMonth>","<ccYear>" and "<cvv>"
    Then User should verify success meg.

    Examples: 
      | username        | password  | location | hotels      | roomType | numOfRooms | checkinDate | checkoutDate | adultRoom | childRoom | firstName | lastName     | address | ccNumber         | ccType | ccMonth | ccYear | cvv |  
      | DivyaBharathiDp | Hello@123 | London   | Hotel Creek | Double   | 4 - Four   | 25/11/2022  | 26/11/2022   | 3 - Three | 3 - Three | Prathiba  | Thiyagarajan | Chennai | 9876543654321210 | VISA   | May     |   2022 | 999 |  
