package com.beiing.baseframe.utils;

import com.tencent.bugly.crashreport.BuglyLog;

import cn.yayi365.yayi.bean.ConversationTop;
import cn.yayi365.yayi.config.Constant;

import org.xutils.DbManager;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.List;
import java.util.Objects;

/**
 * Created by one_v on 2016/3/9 13:26.
 */
public class DBUtil {
    private static DbManager.DaoConfig config;

    private static DbManager manager;

    private static DBUtil instance;

    private DBUtil() {
    }

    public static DBUtil getInstance() {
        if (null == instance) {
            instance = new DBUtil();
        }
        init();
        return instance;
    }

    public static void init() {
        if (null == config)
            config = new DbManager.DaoConfig()
                    .setDbName(Constant.DB_NAME_DEFAULT)
                    .setDbVersion(2)
                    .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                        @Override
                        public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                            switch (newVersion) {
                                case 2:
                                    try {
                                        db.addColumn(ConversationTop.class, "user_id");
                                    } catch (DbException e) {
                                        e.printStackTrace();
                                    }
                            }
                        }
                    })
                    .setDbOpenListener(new DbManager.DbOpenListener() {
                        @Override
                        public void onDbOpened(DbManager db) {
                            // 开启WAL, 对写入加速提升巨大
                            db.getDatabase().enableWriteAheadLogging();
                        }
                    });
        manager = x.getDb(config);
    }

    public void save(Object obj) {
        try {
//            manager.save(obj);
            manager.saveOrUpdate(obj);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public void delete(Object obj) {
        try {
            manager.delete(obj);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public <T> List<T> findAll(Class<T> clz) {
        try {
            if (null != manager.getTable(clz)) {
                return manager.findAll(clz);
            }
        } catch (DbException e) {
            e.printStackTrace();
            BuglyLog.e("wwwwwwwwwwwwwwww", "e---------->" + e.getMessage());
        }
        return null;
    }

    public <T> List<T> findAllBy(Class<T> clz, WhereBuilder builder) {
        try {
            return manager.selector(clz).where(builder).findAll();
        } catch (DbException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T find(Class<T> clz, WhereBuilder builder) {
        try {
            return manager.selector(clz).where(builder).findFirst();
        } catch (DbException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T findFirst(Class<T> clz) {
        try {
            return manager.selector(clz).orderBy("_id", true).findFirst();
        } catch (DbException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void clear(Class clz) {
        try {
            manager.delete(clz);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }


}
