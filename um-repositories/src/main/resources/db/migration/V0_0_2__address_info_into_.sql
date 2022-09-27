-- create countries
insert into db_bank_management_um.t_country (id,country) values('9090db65-08da-4fc8-b870-3e0736e5c35f','Armenia');
insert into db_bank_management_um.t_country (id,country) values('11bf6154-1ef1-4596-b8ce-34f67d4add5f','Artsakh');


-- create states

insert into db_bank_management_um.t_state (id, state, country_id) values('dca28f2b-3cfd-41f0-8fb9-b1405d733194','Lori','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_state (id, state, country_id) values('4804e83e-3bed-490f-82ae-14637ba51fb6','Shirak','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_state (id, state, country_id) values('36ca8ba5-cb9e-410e-a872-ed6a59a517b5','Tavush','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_state (id, state, country_id) values('a30c3fbf-4956-4690-b88b-c200fd31e458','Aragatsotn','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_state (id, state, country_id) values('a3072ab5-57c0-4248-95c6-3938f99dc802','Kotayk','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_state (id, state, country_id) values('adf4eb1e-4477-46ad-be75-e31e6bf4d29d','Gegharkunik','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_state (id, state, country_id) values('1194fd97-6f29-4478-9e38-e92d685a554c','Armavir','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_state (id, state, country_id) values('9ac5e352-a827-4582-81a9-79b48254f668','Ararat','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_state (id, state, country_id) values('0ba3cfe2-fc93-4778-ab69-0023ab350561','Vayots Dzor','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_state (id, state, country_id) values('fbe33900-e731-46f5-bc15-e4c89c2f31ef','Syunik','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_state (id, state, country_id) values('06a8efb1-a4d3-4b1e-8e2e-4db9861ee521','Erevan','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_state (id, state, country_id) values('731446a8-b4a7-456d-9aff-7bffcc104f6c','Martakert','11bf6154-1ef1-4596-b8ce-34f67d4add5f');
insert into db_bank_management_um.t_state (id, state, country_id) values('c9821c09-3008-46c8-bb7b-15d1f0907ad6','Stepanakert','11bf6154-1ef1-4596-b8ce-34f67d4add5f');
insert into db_bank_management_um.t_state (id, state, country_id) values('92a49099-606b-4aaf-a731-21714c0438a8','Martuni','11bf6154-1ef1-4596-b8ce-34f67d4add5f');
insert into db_bank_management_um.t_state (id, state, country_id) values('d048f424-726e-406b-b4bb-1786c7fc22a9','Shushi','11bf6154-1ef1-4596-b8ce-34f67d4add5f');
insert into db_bank_management_um.t_state (id, state, country_id) values('9acbfcbc-b64a-4d7b-91a5-4182c56daf80','Askeran','11bf6154-1ef1-4596-b8ce-34f67d4add5f');
insert into db_bank_management_um.t_state (id, state, country_id) values('b5031854-d303-4bee-9797-d5bf6542bfe7','Kashatagh','11bf6154-1ef1-4596-b8ce-34f67d4add5f');
insert into db_bank_management_um.t_state (id, state, country_id) values('f812c03c-ed16-4f56-9b11-17e20ee13cec','Shahumyan','11bf6154-1ef1-4596-b8ce-34f67d4add5f');
insert into db_bank_management_um.t_state (id, state, country_id) values('51ae9ac2-9a06-4d2d-a782-a31d2b75f356','Hadrut','11bf6154-1ef1-4596-b8ce-34f67d4add5f');

-- create cities

insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('16a896e9-1a06-4750-a2cf-46eb5e347028','Yeghegnadzor','0ba3cfe2-fc93-4778-ab69-0023ab350561','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('85c0462b-d6af-473c-96ec-95203e74fbe1','Vedi','9ac5e352-a827-4582-81a9-79b48254f668','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('6106bc32-0416-4222-b9d0-4c9a64f19f4f','Vayk','0ba3cfe2-fc93-4778-ab69-0023ab350561','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('e55c8428-724a-4069-8d2a-360b4f909bd8','Vardenis','adf4eb1e-4477-46ad-be75-e31e6bf4d29d','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('e9cc2eb0-cd0a-4952-9b60-355cb53202aa','Vanadzor','dca28f2b-3cfd-41f0-8fb9-b1405d733194','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('c9026fbd-5a5c-4452-8e21-ead33d596975','Vagharshapat','1194fd97-6f29-4478-9e38-e92d685a554c','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('8aa24ce9-333f-4b77-a9e2-9acf7052c94a','Tumanyan','dca28f2b-3cfd-41f0-8fb9-b1405d733194','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('6bdfbd93-bfaa-44df-b1aa-2ccd6c55949a','Tsaxkadzor','a3072ab5-57c0-4248-95c6-3938f99dc802','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('e6df7b32-99b7-43b6-9527-067895291627','Tashir','dca28f2b-3cfd-41f0-8fb9-b1405d733194','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('3e04e91c-763d-41a1-8279-99dd4cf26c24','Talin','a30c3fbf-4956-4690-b88b-c200fd31e458','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('9db41062-7ace-4e8c-9d83-51e5dce64ba5','Stepanavan','dca28f2b-3cfd-41f0-8fb9-b1405d733194','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('c70851f0-32bd-480b-90fb-44a554bb966a','Spitak','dca28f2b-3cfd-41f0-8fb9-b1405d733194','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('120192b9-10cb-4525-8559-565390e8a2c9','Sisian','fbe33900-e731-46f5-bc15-e4c89c2f31ef','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('d84a7dfc-0a9a-4a87-9640-7c2c97468c7e','Shamlux','dca28f2b-3cfd-41f0-8fb9-b1405d733194','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('680833d8-1c17-4efa-b872-837cfb0c47fa','Sevan','adf4eb1e-4477-46ad-be75-e31e6bf4d29d','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('aa77b75e-046c-4d0b-9623-ba10c7aff78f','Noyemberyan','36ca8ba5-cb9e-410e-a872-ed6a59a517b5','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('f78cfb05-980c-4707-8f53-8f67e5f5e2b7','Nor Hachn','a3072ab5-57c0-4248-95c6-3938f99dc802','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('23b36a46-81c8-4110-b874-4d30f8caa8ed','Metsamor','1194fd97-6f29-4478-9e38-e92d685a554c','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('e8a14289-db8b-4732-b764-25eda70848a6','Meghri','fbe33900-e731-46f5-bc15-e4c89c2f31ef','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('5e3699e1-23e0-4907-af76-eb76cffb1e5c','Masis','9ac5e352-a827-4582-81a9-79b48254f668','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('829870a7-f836-45f0-9a20-a6e993ad211d','Martuni','adf4eb1e-4477-46ad-be75-e31e6bf4d29d','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('456d0e0c-efb0-4cf3-b021-8126a749730f','Maralik','4804e83e-3bed-490f-82ae-14637ba51fb6','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('555c1866-7f2d-4f65-9784-2694be3643f3','Kapan','fbe33900-e731-46f5-bc15-e4c89c2f31ef','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('c8a34865-5752-49dd-ae18-f321a7ffb1c1','Kajaran','fbe33900-e731-46f5-bc15-e4c89c2f31ef','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('88b98307-3c05-4ad4-9fe5-7e1921db5380','Jermuk','0ba3cfe2-fc93-4778-ab69-0023ab350561','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('a67b33fc-7e11-488d-86e6-e31b0deebd95','Ijevan','36ca8ba5-cb9e-410e-a872-ed6a59a517b5','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('276123ea-6df4-478e-a817-5fdfb960dfde','Hrazdan','a3072ab5-57c0-4248-95c6-3938f99dc802','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('e722ef23-bcda-4ba6-8b68-0d5275e5f155','Hadrut','51ae9ac2-9a06-4d2d-a782-a31d2b75f356','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('05a26711-04aa-428e-a4ee-5ac1c316e113','Gyumri','4804e83e-3bed-490f-82ae-14637ba51fb6','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('556209ff-3b16-487d-b82c-197c673a5d81','Goris','fbe33900-e731-46f5-bc15-e4c89c2f31ef','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('58bac3e5-684d-4071-a99e-c635fff97540','Gavar','adf4eb1e-4477-46ad-be75-e31e6bf4d29d','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('5c537c48-0ca9-4788-99c7-6dff9dc5ae5d','Exvard','a3072ab5-57c0-4248-95c6-3938f99dc802','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('40b0103c-56e9-43bc-bf66-9ad217dd1576','Erevan','06a8efb1-a4d3-4b1e-8e2e-4db9861ee521','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('4dde854f-f0ff-484a-ba18-38652dccc4d4','Dilijan','36ca8ba5-cb9e-410e-a872-ed6a59a517b5','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('270947d2-7d52-4fcb-b75c-509339f947e0','Dastakert','fbe33900-e731-46f5-bc15-e4c89c2f31ef','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('1e4bc5b0-2abc-412d-b477-d4c2f5082ff5','Charentsavan','a3072ab5-57c0-4248-95c6-3938f99dc802','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('2a02cca0-d158-4e07-b04a-cbd90a0ff359','Chambarak','adf4eb1e-4477-46ad-be75-e31e6bf4d29d','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('74f5a8f3-2124-44d0-b985-6cb73a669b06','Byurexavan','a3072ab5-57c0-4248-95c6-3938f99dc802','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('93e5c05a-e4ae-41aa-9b8d-4a142c66ec97','Berd','36ca8ba5-cb9e-410e-a872-ed6a59a517b5','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('72e5fb7a-ea56-4090-81e1-77d906bd5e48','Ayrum','36ca8ba5-cb9e-410e-a872-ed6a59a517b5','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('b3fdf44b-5fd9-43d0-9738-9cc0919727b9','Axtala','dca28f2b-3cfd-41f0-8fb9-b1405d733194','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('6e24da21-f968-400b-93e8-9073c00f9700','Ashtarak','a30c3fbf-4956-4690-b88b-c200fd31e458','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('2a21f068-f992-4176-847c-ccd54ac88f02','Artik','4804e83e-3bed-490f-82ae-14637ba51fb6','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('b27b4304-b9fb-45e2-b07e-b162dda1e1d8','Artashat','9ac5e352-a827-4582-81a9-79b48254f668','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('fb6129a5-9f79-4073-a536-5d20b8a04810','Armavir','1194fd97-6f29-4478-9e38-e92d685a554c','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('4a8f4f34-b1b5-434a-a5dc-aad73cfa21e3','Ararat','9ac5e352-a827-4582-81a9-79b48254f668','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('1d8f0cf3-645d-4827-8f84-ae1f8a6a45c0','Aparan','a30c3fbf-4956-4690-b88b-c200fd31e458','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('a70918b5-4dcb-4f8b-812a-b0825c8efbf5','Alaverdi','dca28f2b-3cfd-41f0-8fb9-b1405d733194','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('0b225df5-0e3f-406c-9517-9ff190516b00','Agarak','fbe33900-e731-46f5-bc15-e4c89c2f31ef','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('ae49ce93-b88d-48dc-8d3e-c5c8fb6828f5','Abovyan','a3072ab5-57c0-4248-95c6-3938f99dc802','9090db65-08da-4fc8-b870-3e0736e5c35f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('2d3440f0-2d0f-478b-8d2d-c9e437413627','Stepanakert','c9821c09-3008-46c8-bb7b-15d1f0907ad6','11bf6154-1ef1-4596-b8ce-34f67d4add5f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('e5df4572-8893-4b5e-808f-de1b2ba482d1','Shushi','d048f424-726e-406b-b4bb-1786c7fc22a9','11bf6154-1ef1-4596-b8ce-34f67d4add5f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('b268dfe7-e226-49d6-990e-69c02c11273b','Shahumyan','f812c03c-ed16-4f56-9b11-17e20ee13cec','11bf6154-1ef1-4596-b8ce-34f67d4add5f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('5156a86a-785d-42c5-99ce-a59d984c135c','Mijnavan','b5031854-d303-4bee-9797-d5bf6542bfe7','11bf6154-1ef1-4596-b8ce-34f67d4add5f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('42cb8c76-823c-4e57-af75-2cd76a82a5ea','Martuni','92a49099-606b-4aaf-a731-21714c0438a8','11bf6154-1ef1-4596-b8ce-34f67d4add5f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('44851004-ab2b-4b60-9f3a-d3821d8c2871','Martakert','731446a8-b4a7-456d-9aff-7bffcc104f6c','11bf6154-1ef1-4596-b8ce-34f67d4add5f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('15f7f82b-3e5a-485c-89d7-90299b921510','Kovsakan','b5031854-d303-4bee-9797-d5bf6542bfe7','11bf6154-1ef1-4596-b8ce-34f67d4add5f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('1ad1881a-fc1a-448a-b491-209896504490','Karvachar','f812c03c-ed16-4f56-9b11-17e20ee13cec','11bf6154-1ef1-4596-b8ce-34f67d4add5f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('18160aca-800e-4f8c-802b-8eb9d96a8677','Berdzor','b5031854-d303-4bee-9797-d5bf6542bfe7','11bf6154-1ef1-4596-b8ce-34f67d4add5f');
insert into db_bank_management_um.t_city (id, city, state_id, country_id) values('bb4aab64-9616-4b84-983e-5c63eb3aa19d','Askeran','9acbfcbc-b64a-4d7b-91a5-4182c56daf80','11bf6154-1ef1-4596-b8ce-34f67d4add5f');
