create table t_resource(
	id varchar2(44) primary key,
	resource_name varchar2(300),
	resource_code varchar2(50),
	resource_type varchar2(50),
	url varchar2(200),
	resource_parent varchar2(44),
	action varchar2(100),
	state varchar2(50),
	order number(10),
	remark varchar2(2000),
	created_by varchar2(44),
	created_date date,
	updated_by varchar2(44),
	updated_date date	
);
COMMENT ON COLUMN PIMS.T_RESOURCE.ID IS '主键' ;
COMMENT ON COLUMN PIMS.T_RESOURCE.RESOURCE_NAME IS '资源名称' ;
COMMENT ON COLUMN PIMS.T_RESOURCE.RESOURCE_CODE IS '资源编号' ;
COMMENT ON COLUMN PIMS.T_RESOURCE.RESOURCE_TYPE IS '资源类型' ;
COMMENT ON COLUMN PIMS.T_RESOURCE.URL IS '地址' ;
COMMENT ON COLUMN PIMS.T_RESOURCE.RESOURCE_PARENT IS '父级资源' ;
COMMENT ON COLUMN PIMS.T_RESOURCE."ACTION" IS '操作' ;
COMMENT ON COLUMN PIMS.T_RESOURCE.STATE IS '状态' ;
COMMENT ON COLUMN PIMS.T_RESOURCE.ORDER_NO IS '编号' ;
COMMENT ON COLUMN PIMS.T_RESOURCE.REMARK IS '备注' ;
COMMENT ON COLUMN PIMS.T_RESOURCE.CREATED_BY IS '创建人' ;
COMMENT ON COLUMN PIMS.T_RESOURCE.CREATED_DATE IS '创建时间' ;
COMMENT ON COLUMN PIMS.T_RESOURCE.UPDATED_BY IS '修改人' ;
COMMENT ON COLUMN PIMS.T_RESOURCE.UPDATED_DATE IS '修改时间' ;

create table t_role(
	id varchar2(44) primary key,
	role_name varchar2(300),
	role_code varchar2(50),
	role_type varchar2(50),
	role_parent varchar2(44),
	state varchar2(50),
	order number(10),
	remark varchar2(2000),
	created_by varchar2(44),
	created_date date,
	updated_by varchar2(44),
	updated_date date
);
COMMENT ON COLUMN PIMS.T_ROLE.ID IS '主键' ;
COMMENT ON COLUMN PIMS.T_ROLE.ROLE_NAME IS '角色名称' ;
COMMENT ON COLUMN PIMS.T_ROLE.ROLE_CODE IS '角色编码' ;
COMMENT ON COLUMN PIMS.T_ROLE.ROLE_TYPE IS '角色类型' ;
COMMENT ON COLUMN PIMS.T_ROLE.ROLE_PARENT IS '父级角色' ;
COMMENT ON COLUMN PIMS.T_ROLE.STATE IS '状态' ;
COMMENT ON COLUMN PIMS.T_ROLE.ORDER_NO IS '编号' ;
COMMENT ON COLUMN PIMS.T_ROLE.REMARK IS '备注' ;
COMMENT ON COLUMN PIMS.T_ROLE.CREATED_BY IS '创建人' ;
COMMENT ON COLUMN PIMS.T_ROLE.CREATED_DATE IS '创建时间' ;
COMMENT ON COLUMN PIMS.T_ROLE.UPDATED_BY IS '修改人' ;
COMMENT ON COLUMN PIMS.T_ROLE.UPDATED_DATE IS '修改时间' ;

create table t_user(
	id varchar2(44) primary key,
	user_id varchar2(300),
	username varchar2(300),
	password varchar2(50),
	tel varchar2(20),
	address varchar2(300),
	state varchar2(20),
	remark varchar2(2000),
	created_by varchar2(44),
	created_date date,
	updated_by varchar2(44),
	updated_date date
);
COMMENT ON COLUMN PIMS.T_USER.ID IS '主键' ;
COMMENT ON COLUMN PIMS.T_USER.USER_ID IS '账号' ;
COMMENT ON COLUMN PIMS.T_USER.USERNAME IS '名称' ;
COMMENT ON COLUMN PIMS.T_USER.PASSWORD IS '密码' ;
COMMENT ON COLUMN PIMS.T_USER.TEL IS '联系方式' ;
COMMENT ON COLUMN PIMS.T_USER.ADDRESS IS '地址' ;
COMMENT ON COLUMN PIMS.T_USER.STATE IS '状态' ;
COMMENT ON COLUMN PIMS.T_USER.REMARK IS '备注' ;
COMMENT ON COLUMN PIMS.T_USER.CREATED_BY IS '创建时间' ;
COMMENT ON COLUMN PIMS.T_USER.CREATED_DATE IS '创建人' ;
COMMENT ON COLUMN PIMS.T_USER.UPDATED_BY IS '修改时间' ;
COMMENT ON COLUMN PIMS.T_USER.UPDATED_DATE IS '修改人' ;

create table t_role_resource_relation(
	id varchar2(44) primary key,
	role_code varchar2(50) not null,
	resource_code varchar2(50) not null,
	created_by varchar2(44),
	created_date date,
	updated_by varchar2(44),
	updated_date date
);

create table t_user_role_relation(
	id varchar2(44) primary key,
	role_code varchar2(50) not null,
	user_id varchar2(300) not null,
	created_by varchar2(44),
	created_date date,
	updated_by varchar2(44),
	updated_date date
);

create table t_dict_info(
	id varchar2(44) primary key,
	parent_id varchar2(44),
	dict_type_code varchar2(100) not null,
	dict_type_name varchar2(300) not null,
	dict_code varchar2(100) not null,
	dict_name varchar2(300) not null,
	order_no number(10),
	state varchar2(20),
	created_by varchar2(44),
	created_date date,
	updated_by varchar2(44),
	updated_date date
);
CREATE TABLE t_storehouse(
  id varchar2(44) primary key,
  area varchar2(50),
  room varchar2(50),
  goods_type varchar2(50),
  goods_name varchar2(300),
  amount number(28,10),
  state varchar2(20),
  remark varchar2(2000),
  created_by varchar2(44),
  created_date date,
  updated_by varchar2(44),
  updated_date date
);

CREATE TABLE t_action_log(
  id varchar2(44) primary key,
  parent_id varchar2(44),
  amount number(28,10),
  action_date date,
  action_type varchar2(50),
  apply_user varchar2(44),
  audit_user varchar2(44),
  handle_user varchar2(44),
  remark varchar2(2000),
  created_by varchar2(44),
  created_date date,
  updated_by varchar2(44),
  updated_date date
);

CREATE TABLE t_document_info(
	id varchar2(44) primary key,
	name varchar2(300),
	url varchar2(300),
	save_name varchar2(2000),
	remark varchar2(2000),
	created_by varchar2(44),
	created_date date,
	updated_by varchar2(44),
	updated_date date
);

CREATE TABLE t_document_info_relation(
  id varchar2(44) primary key,
  document_id varchar2(44),
  relation_id varchar2(44),
  relation_type varchar2(50),
  relation_code varchar2(50),
  remark varchar2(2000),
  created_by varchar2(44),
  created_date date,
  updated_by varchar2(44),
  updated_date date
);

CREATE TABLE t_personal_reservation(
	id varchar2(44) primary key,
	area varchar2(44),
	room_code varchar2(44),
	dinner_time_code varchar2(50),
	contact_user varchar2(50),
	remark varchar2(2000),
	created_by varchar2(44),
	created_date date,
	updated_by varchar2(44),
	updated_date date
);

CREATE TABLE t_dinner_party(
  id varchar2(44) primary key,
  dinner_party_type varchar2(100),
  dinner_party_user varchar2(44),
  tel varchar2(50),
  consumption_item varchar2(900),
  remark varchar2(2000),
  created_by varchar2(44),
  created_date date,
  updated_by varchar2(44),
  updated_date date
);