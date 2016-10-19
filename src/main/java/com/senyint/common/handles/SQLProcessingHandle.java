package com.senyint.common.handles;


import com.senyint.common.abs.BaseHandle;
import com.senyint.common.dao.MessageDao;

public class SQLProcessingHandle  extends BaseHandle implements IHandle {

    private MessageDao messageDao;
    
    public MessageDao getMessageDao() {
        return messageDao;
    }

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public Object Invoke(Object... obj) throws Exception {
        // TODO Auto-generated method stub
        messageDao.qryNotice();
        return null;
    }

}
