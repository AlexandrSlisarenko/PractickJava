create table user_subscription (
    channel_id int8 not null references usr1,
    subscriber_id int8 not null references usr1,
    primary key (channel_id, subscriber_id)
)