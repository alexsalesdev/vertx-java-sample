CREATE SCHEMA ourparents
--
-- Table structure for table geocodes
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE my.geocodes (
  id int(11) NOT NULL AUTO_INCREMENT,
  name_key varchar(255) DEFAULT NULL,
  lat float DEFAULT NULL,
  lng float DEFAULT NULL,
  location varchar(255) DEFAULT NULL,
  state varchar(255) DEFAULT NULL,
  city varchar(255) DEFAULT NULL,
  zip varchar(255) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  updated_at datetime DEFAULT NULL,
  expose tinyint(1) DEFAULT '0',
  priority int(11) DEFAULT '0',
  PRIMARY KEY (id),
  UNIQUE KEY index_geocodes_on_name_key (name_key),
  KEY index_geocodes_on_lat_and_lng (lat,lng),
  KEY index_geocodes_on_location (location),
  KEY selects (location,city,state)
) ENGINE=MyISAM AUTO_INCREMENT=308135 DEFAULT CHARSET=UTF8;
/*!40101 SET character_set_client = @saved_cs_client */;
