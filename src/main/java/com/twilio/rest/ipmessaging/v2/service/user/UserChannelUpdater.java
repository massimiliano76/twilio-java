/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.ipmessaging.v2.service.user;

import com.twilio.base.Updater;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.time.ZonedDateTime;

public class UserChannelUpdater extends Updater<UserChannel> {
    private final String pathServiceSid;
    private final String pathUserSid;
    private final String pathChannelSid;
    private UserChannel.NotificationLevel notificationLevel;
    private Integer lastConsumedMessageIndex;
    private ZonedDateTime lastConsumptionTimestamp;

    /**
     * Construct a new UserChannelUpdater.
     *
     * @param pathServiceSid The service_sid
     * @param pathUserSid The user_sid
     * @param pathChannelSid The channel_sid
     */
    public UserChannelUpdater(final String pathServiceSid,
                              final String pathUserSid,
                              final String pathChannelSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathUserSid = pathUserSid;
        this.pathChannelSid = pathChannelSid;
    }

    /**
     * The notification_level.
     *
     * @param notificationLevel The notification_level
     * @return this
     */
    public UserChannelUpdater setNotificationLevel(final UserChannel.NotificationLevel notificationLevel) {
        this.notificationLevel = notificationLevel;
        return this;
    }

    /**
     * The last_consumed_message_index.
     *
     * @param lastConsumedMessageIndex The last_consumed_message_index
     * @return this
     */
    public UserChannelUpdater setLastConsumedMessageIndex(final Integer lastConsumedMessageIndex) {
        this.lastConsumedMessageIndex = lastConsumedMessageIndex;
        return this;
    }

    /**
     * The last_consumption_timestamp.
     *
     * @param lastConsumptionTimestamp The last_consumption_timestamp
     * @return this
     */
    public UserChannelUpdater setLastConsumptionTimestamp(final ZonedDateTime lastConsumptionTimestamp) {
        this.lastConsumptionTimestamp = lastConsumptionTimestamp;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated UserChannel
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public UserChannel update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.IPMESSAGING.toString(),
            "/v2/Services/" + this.pathServiceSid + "/Users/" + this.pathUserSid + "/Channels/" + this.pathChannelSid + ""
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("UserChannel update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return UserChannel.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (notificationLevel != null) {
            request.addPostParam("NotificationLevel", notificationLevel.toString());
        }

        if (lastConsumedMessageIndex != null) {
            request.addPostParam("LastConsumedMessageIndex", lastConsumedMessageIndex.toString());
        }

        if (lastConsumptionTimestamp != null) {
            request.addPostParam("LastConsumptionTimestamp", lastConsumptionTimestamp.toOffsetDateTime().toString());
        }
    }
}