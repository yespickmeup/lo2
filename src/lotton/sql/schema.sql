/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Jul 31, 2018
 */

drop schema if exists lotto;
create schema lotto;
use lotto;

create table 6_58(
id int auto_increment primary key
,result_date date
,result varchar(255)
);