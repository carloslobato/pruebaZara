# Technical Test Zara

Zara Technical Test Project



In the company's electronic commerce database, we have a PRICES table that reflects the final price (pvp) and the rate applied by a product from a chain between certain dates. Below is an example of the table with the relevant fields:

PRICES

-------

BRAND_ID         START_DATE                                    END_DATE                        PRICE_LIST                   PRODUCT_ID  PRIORITY                 PRICE           CURR

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

1         2020-06-14-00.00.00                        2020-12-31-23.59.59                        1                        35455                0                        35.50            EUR

1         2020-06-14-15.00.00                        2020-06-14-18.30.00                        2                        35455                1                        25.45            EUR

1         2020-06-15-00.00.00                        2020-06-15-11.00.00                        3                        35455                1                        30.50            EUR

1         2020-06-15-16.00.00                        2020-12-31-23.59.59                        4                        35455                1                        38.95            EUR

Build an application / service in SpringBoot that provides a query rest end point such that:
 

Accept as input parameters: application date, product identifier, string identifier.
Return as output data: product identifier, chain identifier, rate to apply, application dates and final price to apply.
 

You must use an in-memory database (type h2) and initialize with the data of the example, (you can change the name of the fields and add new ones if you want, choose the type of data that is considered appropriate for them ).

              
# Add a "Postman" folder in the root of the project with the tests performed

Develop tests to the rest endpoint that validate the following requests to the service with the data from the example:
                                                                                       

- Test 1: request at 10:00 on the 14th of product 35455 for brand 1 (ZARA)

- Test 2: request at 16:00 on the 14th of product 35455 for brand 1 (ZARA)

- Test 3: request at 21:00 on the 14th of product 35455 for brand 1 (ZARA)

- Test 4: request at 10:00 on the 15th of product 35455 for brand 1 (ZARA)

- Test 5: request at 21:00 on the 16th of product 35455 for brand 1 (ZARA)

