package com.dkorniichuk.app.dao.util;


public class SqlSearchQueryGenerator {
    public static String generateQuery(String parameter){
        return "SELECT * FROM product WHERE lower(product_name) like \"%?"+parameter
                +"%\" or id_product like \"%"+parameter
                +"%\" or product_description like \"%"+parameter+"%\"";
    }
}
