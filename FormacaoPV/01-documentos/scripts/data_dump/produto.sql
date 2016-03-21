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
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: produtopv
--

COPY produto (id, comissao, custo, descontoimposto, lucro, nome) FROM stdin;
1	0.100000000000000006	100	30	0.5	Produto 1
2	0.200000000000000011	200	62	0.5	Produto 2
52	4	4	0.200000000000000011	4	teste
151	0.200000000000000011	200	62	0.5	Produto 3
201	0.200000000000000011	200	62	0.5	Produto 4
251	0.200000000000000011	200	62	0.5	Produto 5
301	0.200000000000000011	200	62	0.5	Produto 6
351	0.200000000000000011	200	62	0.5	Produto 7
401	0.200000000000000011	200	62	0.5	Produto 8
\.


--
-- PostgreSQL database dump complete
--

