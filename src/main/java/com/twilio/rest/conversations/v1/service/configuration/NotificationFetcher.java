/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.conversations.v1.service.configuration;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class NotificationFetcher extends Fetcher<Notification> {
    private final String pathChatServiceSid;

    /**
     * Construct a new NotificationFetcher.
     *
     * @param pathChatServiceSid The SID of the Conversation Service that the
     *                           Configuration applies to.
     */
    public NotificationFetcher(final String pathChatServiceSid) {
        this.pathChatServiceSid = pathChatServiceSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched Notification
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Notification fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.CONVERSATIONS.toString(),
            "/v1/Services/" + this.pathChatServiceSid + "/Configuration/Notifications"
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Notification fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Notification.fromJson(response.getStream(), client.getObjectMapper());
    }
}