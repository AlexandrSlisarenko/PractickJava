<#import "parts/common.ftl" as baseContainer>
<#include "parts/security.ftl">
<@baseContainer.page>
<h3>${userChannel.username}</h3>
<#if !isCurrentUser>
    <#if isSubscriber>
        <a class="btn btn-info" href="/user/unsubscribe/${userChannel.id}">Unsubscribe</a>
    <#else>
        <a class="btn btn-info" href="/user/subscribe/${userChannel.id}">Subscribe</a>
    </#if>
</#if>
<div class="container my-3">
    <div class="row">
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Subscriptions</h5>
                    <a href="/user/subscriptions/${userChannel.id}/list"><span style="font-weight:bold; text-align:right;">${subscriptionsCount}</span></a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Subscribers</h5>
                    <a href="/user/subscribers/${userChannel.id}/list"><span style="font-weight:bold; text-align:right;">${subscribersCount}</span></a>
                </div>
            </div>
        </div>
    </div>
</div>
<#if isCurrentUser>
    <#include "parts/addMessage.ftl" />
</#if>
<#include "parts/getMessage.ftl">
</@baseContainer.page>

