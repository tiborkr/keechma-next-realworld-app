(ns app.ui.pages.login
  (:require [keechma.next.helix.core :refer [with-keechma]]
            [keechma.next.helix.lib :refer [defnc]]
            [helix.core :as hx :refer [$ <> suspense]]
            [helix.dom :as d]
            ["react" :as react]
            ["react-dom" :as rdom]
            [app.ui.components.inputs :refer [wrapped-input]]))



(defnc LoginRenderer
  [{:keechma/keys [send!]}]
  (d/div
    {:class "auth-page"}
    (d/div
      {:class "container page"}
      (d/div
        {:class "row"}
        (d/div
          {:class "col-md-6 offset-md-3 col-xs-12"}
          (d/h1
            {:class "text-xs-center"}
            "Sign in")
          (d/p
            {:class "text-xs-center"}
            (d/a {:href (send! :router :get-url {:page "register"})} "Need an account?"))
          (d/form
            {:on-submit (fn [e]
                          (.preventDefault e)
                          (send! :login :keechma.form/submit))}
            (wrapped-input {:keechma.form/controller :login
                            :input/type :text
                            :input/attr :email
                            :placeholder "Email"})
            (wrapped-input {:keechma.form/controller :login
                            :input/type :text
                            :input/attr [:password]
                            :type :password
                            :placeholder "Password" })
            (d/button
              {:class "btn btn-lg btn-primary pull-xs-right"} "Sign In")))))))

(def Login (with-keechma LoginRenderer))
