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
-- Data for Name: movimentacao; Type: TABLE DATA; Schema: public; Owner: fpvuser
--

COPY movimentacao (id, data, descricao, quantidade, valor, venda, localidade_id, produto_id) FROM stdin;
1	2016-03-21 00:00:00		\N	10	f	\N	\N
2	2016-03-21 00:00:00		\N	20	f	\N	1
3	2016-03-21 00:00:00		\N	15	f	\N	\N
4	2016-03-21 00:00:00		\N	30	f	\N	151
5	2016-03-21 00:00:00		5	360	t	1	251
6	2016-03-21 00:00:00		1	480	t	1	1
7	2016-03-21 00:00:00		1	300	t	2	301
\.


--
-- PostgreSQL database dump complete
--

