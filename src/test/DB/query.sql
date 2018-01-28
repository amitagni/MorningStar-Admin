CREATE TABLE `day_book` (
  `id` int(8) NOT NULL,
  `account_name` varchar(50) DEFAULT NULL,
  `desc` varchar(50) DEFAULT NULL,
  `transaction_type` int(8) DEFAULT NULL,
  `payment_type` int(8) DEFAULT NULL,
  `cheque_no` int(8) DEFAULT NULL,
  `epay_no` int(20) DEFAULT NULL,
  `amount` int(20) DEFAULT NULL,
  `comments` varchar(500) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
