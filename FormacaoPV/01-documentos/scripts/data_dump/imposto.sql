--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- Data for Name: imposto; Type: TABLE DATA; Schema: public; Owner: produtopv
--

COPY imposto (id, nome, percentagem) FROM stdin;
1	IRRPJ	0.299999999999999989
2	ISSQN	0.200000000000000011
3	INSS	0.110000000000000001
4	COFINS	0.100000000000000006
5	PIS	0.220000000000000001
6	ICMS	0.0500000000000000028
\.


--
-- PostgreSQL database dump complete
--

