#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE USER logistore WITH PASSWORD 'logistore';
	CREATE DATABASE logistore;
	GRANT ALL PRIVILEGES ON DATABASE logistore TO logistore;
EOSQL
