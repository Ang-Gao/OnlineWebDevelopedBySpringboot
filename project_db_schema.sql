CREATE TABLE "customers_account"
(
    "id" bigserial PRIMARY KEY,
    "owner"    varchar NOT NULL,
    "balance"  bigint  NOT NULL,
    "currency" varchar NOT NULL,
    "created_at" timestamptz NOT NULL DEFAULT (now())
);

CREATE TABLE "groups_account"
(
    "id" bigserial PRIMARY KEY,
    "owner"          varchar NOT NULL,
    "balance"        bigint  NOT NULL,
    "currency"       varchar NOT NULL,
    "created_at" timestamptz NOT NULL DEFAULT (now()),
    "mission_vision" varchar
);

CREATE TABLE "transfer_money"
(
    "id" bigserial PRIMARY KEY,
    "from_account_id" bigint,
    "to_account_id"   bigint,
    "amount"          bigint    NOT NULL,
    "created_at"      timestamp NOT NULL DEFAULT (now())
);

CREATE TABLE "donated_entities"
(
    "id" bigserial PRIMARY KEY,
    "from_account_id" bigint,
    "delivery_status" varchar NOT NULL
);

CREATE TABLE "user_details"
(
    "id" bigserial PRIMARY KEY,
    "username"     varchar NOT NULL,
    "age"          varchar NOT NULL,
    "email"        varchar NOT NULL,
    "address"      varchar NOT NULL,
    "user_password" varchar NOT NULL
);

CREATE INDEX ON "customers_account" ("owner");

CREATE INDEX ON "groups_account" ("owner");

CREATE INDEX ON "transfer_money" ("from_account_id");

CREATE INDEX ON "transfer_money" ("to_account_id");

CREATE INDEX ON "transfer_money" ("from_account_id", "to_account_id");

ALTER TABLE "transfer_money"
    ADD FOREIGN KEY ("from_account_id") REFERENCES "customers_account" ("id");

ALTER TABLE "transfer_money"
    ADD FOREIGN KEY ("to_account_id") REFERENCES "groups_account" ("id");

ALTER TABLE "user_details"
    ADD FOREIGN KEY ("id") REFERENCES "customers_account" ("id");
