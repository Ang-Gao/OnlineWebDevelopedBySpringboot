CREATE TABLE "customersAccount" (
  "id" bigserial PRIMARY KEY,
  "owner" varchar NOT NULL,
  "balance" bigint NOT NULL,
  "currency" varchar NOT NULL,
  "created_at" timestamptz NOT NULL DEFAULT (now())
);

CREATE TABLE "groupsAccount" (
  "id" bigserial PRIMARY KEY,
  "owner" varchar NOT NULL,
  "balance" bigint NOT NULL,
  "currency" varchar NOT NULL,
  "created_at" timestamptz NOT NULL DEFAULT (now()),
  "missionNVision" varchar
);

CREATE TABLE "transferMoney" (
  "id" bigserial PRIMARY KEY,
  "from_account_id" bigint,
  "to_account_id" bigint,
  "amount" bigint NOT NULL,
  "created_at" timestamp NOT NULL DEFAULT (now())
);

CREATE TABLE "donatedEntities" (
  "id" bigserial PRIMARY KEY,
  "from_account_id" bigint,
  "delivery_status" varchar NOT NULL
);

CREATE TABLE "userDetails" (
  "id" bigserial PRIMARY KEY,
  "username" varchar NOT NULL,
  "age" varchar NOT NULL,
  "email" varchar NOT NULL,
  "address" varchar NOT NULL,
  "userPassword" varchar NOT NULL
);

CREATE INDEX ON "customersAccount" ("owner");

CREATE INDEX ON "groupsAccount" ("owner");

CREATE INDEX ON "transferMoney" ("from_account_id");

CREATE INDEX ON "transferMoney" ("to_account_id");

CREATE INDEX ON "transferMoney" ("from_account_id", "to_account_id");

ALTER TABLE "transferMoney" ADD FOREIGN KEY ("from_account_id") REFERENCES "customersAccount" ("id");

ALTER TABLE "transferMoney" ADD FOREIGN KEY ("to_account_id") REFERENCES "groupsAccount" ("id");

ALTER TABLE "userDetails" ADD FOREIGN KEY ("id") REFERENCES "customersAccount" ("id");
