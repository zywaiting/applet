package com.zy.applet.wechatbot.api.response;

import com.google.gson.annotations.SerializedName;
import com.zy.applet.wechatbot.api.model.Account;
import com.zy.applet.wechatbot.api.model.Message;
import com.zy.applet.wechatbot.api.model.Profile;
import com.zy.applet.wechatbot.api.model.SyncKey;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * WebSync 响应
 *
 * @author biezhi
 * @date 2018/1/20
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WebSyncResponse extends JsonResponse {

    @SerializedName("AddMsgCount")
    private Integer addMsgCount;

    @SerializedName("AddMsgList")
    private List<Message> addMessageList;

    @SerializedName("ModContactCount")
    private Integer modContactCount;

    @SerializedName("ModContactList")
    private List<Account> modContactList;

    @SerializedName("DelContactCount")
    private Integer delContactCount;

    @SerializedName("DelContactList")
    private List<Account> delContactList;

    @SerializedName("ModChatRoomMemberCount")
    private Integer modChatRoomMemberCount;

    @SerializedName("ModChatRoomMemberList")
    private List<Account> modChatRoomMemberList;

    @SerializedName("Profile")
    private Profile profile;

    @SerializedName("ContinueFlag")
    private Integer continueFlag;

    @SerializedName("SyncKey")
    private SyncKey syncKey;

    @SerializedName("SKey")
    private String sKey;

    @SerializedName("SyncCheckKey")
    private SyncKey syncCheckKey;

}
