import { createContext, useContext, useState } from "react";

const ChatContext=createContext()

//normal function as provider for context api
export const ChatProvider=({children})=>{
   
    const [roomId,setRoomId]=useState('')
    const [currentUser,setCurrentUser]=useState('')
    const [connected,setConnected]=useState(false)

    return <ChatContext.Provider value={{roomId,currentUser,connected,setRoomId,setCurrentUser,setConnected}}>{children}</ChatContext.Provider>;
};

const useChatContext=()=>useContext(ChatContext);
export default useChatContext;    //step 1

//basically by context api, we can access it from any page i.e home,chat (global)