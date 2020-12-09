package com.huawei.it.notify.utils;

import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;

public class JGitTest {


    public static String cloneRepository(String url,String localPath)
    {
        try{
            System.out.println("开始下载......");

            CloneCommand cc = Git.cloneRepository().setURI(url);
            cc.setDirectory(new File(localPath)).call();

            System.out.println("下载完成......");

            return "success";
        }catch(Exception e)
        {
            e.printStackTrace();
            return "error";
        }
    }

    public static String pullRepository(String url)
    {
        try{
            System.out.println("开始更新......");
            Git git = Git.init().setDirectory(new File("C:\\Users\\ywx348109\\Desktop\\tmp")).call();
            PullCommand cc = git.pull();
            cc.call();
            System.out.println(cc.getRemoteBranchName());
            System.out.println(cc.getRemote());

            System.out.println("更新完成......");

            return "success";
        }catch(Exception e)
        {
            e.printStackTrace();
            return "error";
        }
    }


    public static String checkOut(String url)
    {
        try{
            System.out.println("开始更新......");
            Git git = Git.init().setDirectory(new File("C:\\Users\\ywx348109\\Desktop\\tmp")).call();
            CheckoutCommand cc = git.checkout();
            cc.setName("fossbot");
            cc.setCreateBranch(true);
            System.out.println(cc.getResult());

            System.out.println("更新完成......");

            return "success";
        }catch(Exception e)
        {
            e.printStackTrace();
            return "error";
        }
    }


    public static void main(String[] args)
    {
        String localPath = "C:\\Users\\ywx348109\\Desktop\\tmp";
        String url = "ssh://git@git.huawei.com:2222/digitalipdIce/ice_windchill_jar.git";

        checkOut(url);
    }

    private static UsernamePasswordCredentialsProvider provide() {
        return new UsernamePasswordCredentialsProvider("ywx348109", "!W8Y-Hpq");
    }
}
