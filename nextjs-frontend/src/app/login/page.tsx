import AuthButton from "@/components/button/authButton";
import AuthInput from "@/components/input/authInput";

function LoginPage() {
  return (
    <div className="flex min-h-screen items-center justify-center px-6 py-12 lg:px-8">
      <div className="sm:mx-auto sm:w-full sm:max-w-sm mt-[-100px] relative"> 
        <h2 className="text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">
          Sign in to your account
        </h2>
        <form action="#" method="POST" className="mt-8 space-y-6">
          <div>
            <label htmlFor="email" className="block text-sm font-medium leading-6 text-gray-900">
              Email address
            </label>
            <div className="mt-2">
              <AuthInput
                id="email"
                name="email"
                type="email"
                required={true}
                autoComplete="email"
              />
            </div>
          </div>

          <div>
            <div className="flex items-center justify-between">
              <label htmlFor="password" className="block text-sm font-medium leading-6 text-gray-900">
                Password
              </label>
              <div className="text-sm">
                <a href="#" className="font-semibold text-indigo-600 hover:text-indigo-500">
                  Forgot password?
                </a>
              </div>
            </div>
            <div className="mt-2">
              <AuthInput
                id="password"
                name="password"
                type="password"
                required={true}
                autoComplete="current-password"
              />
            </div>
          </div>

          <div className="mt-6">
            <AuthButton type="submit" className="my-custom-class">
              Sign in
            </AuthButton>
          </div>
        </form>
      </div>
    </div>
  )
}

export default LoginPage;
